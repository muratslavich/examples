package com.prot.example

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*

@SpringBootApplication
class Main

fun main() {
    runApplication<Main>()
}

@RestController
class ImageController(
    val dataPath: Path,
) {

    @PostMapping("/image")
    fun uploadImage(
        @RequestParam payload: MultipartFile
    ): String {
        val uid = UUID.randomUUID().toString()
        val path = Paths.get(dataPath.toString(), uid)
        Files.write(path, payload.bytes, StandardOpenOption.CREATE_NEW)
        return uid
    }

    @GetMapping("/image/{uid}")
    fun getImage(
        @PathVariable uid: String
    ): StreamingResponseBody {
        val path = Paths.get(dataPath.toString(), uid)
        val fileInputStream = FileInputStream(File(path.toUri()))
        return StreamingResponseBody {
            FileCopyUtils.copy(fileInputStream, it)
        }
    }
}

const val UPLOAD_DIRECTORY = "/images/upload"

@Configuration
class Config {
    @Bean
    fun checkDirectories(@Value("\${data.dir}") absolutePath: String): Path =
        Files.createDirectories(Paths.get(absolutePath + UPLOAD_DIRECTORY))
}