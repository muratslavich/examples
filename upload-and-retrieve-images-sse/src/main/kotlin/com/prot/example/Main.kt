package com.prot.example

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody
import java.io.File
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*

@SpringBootApplication
class Main

fun main() {
    runApplication<Main>()
}

const val UPLOAD_DIRECTORY = "/images/upload"

@RestController
class ImageController(
    @Value("\${data.dir}") val absolutePath: String
) {

    @PostMapping("/image")
    fun uploadImage(
        @RequestParam payload: MultipartFile
    ): String {
        val uid = UUID.randomUUID().toString()
        val path = Paths.get(absolutePath + UPLOAD_DIRECTORY, uid)
        Files.write(path, payload.bytes, StandardOpenOption.CREATE_NEW)
        return uid
    }

    @GetMapping("/image/{uid}")
    fun getImage(
        @PathVariable uid: String
    ): StreamingResponseBody {
        val path = Paths.get(absolutePath + UPLOAD_DIRECTORY, uid)
        val fileInputStream = FileInputStream(File(path.toUri()))
        return StreamingResponseBody {
            FileCopyUtils.copy(fileInputStream, it)
        }
    }
}