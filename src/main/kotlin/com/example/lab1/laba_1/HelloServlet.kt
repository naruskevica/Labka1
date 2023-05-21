package com.example.lab1.laba_1

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@WebServlet(name = "helloServlet", value = ["/process"])
class HelloServlet : HttpServlet() {
    private lateinit var message: String

    @Throws(IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val key: String? = request.getParameter("key")
        val value: Int = request.getParameter("value")?.toIntOrNull() ?: 0
        val test: Boolean = request.getParameter("test")?.toBoolean() ?: false

        if (test) {
            response.contentType = "text/html"
            val out = response.writer
            out.println("<html><body><h1>Confirmation</h1><p>Confirmation message here.</p></body></html>")
        } else {
            val line = "Key: $key, ${repeatString(key, value)},${getCurrentTimestamp()}"
            writeToFile(line)
            val content = readFromFile()
            response.contentType = "text/html"
            val out = response.writer
            out.println("<html>" +
                    "<body>" +
                    "<h1>Repository Content</h1>" +
                    "<pre>$content</pre>" +
                    "</body>" +
                    "</html>")
        }
    }

    private fun repeatString(str: String?, times: Int): String {
        val builder = StringBuilder()
        for (i in 0 until times) {
            builder.append(str)
        }
        return builder.toString()
    }

    private fun getCurrentTimestamp(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = Date()
        return dateFormat.format(date)
    }

    @Throws(IOException::class)
    private fun writeToFile(line: String) {
        val filePath = "database.txt"
        val writer = FileWriter(File(filePath), true)
        writer.write(line + System.lineSeparator())
        writer.close()
    }

    @Throws(IOException::class)
    private fun readFromFile(): String {
        val filePath = "database.txt"
        val file = File(filePath)
        if (!file.exists()) return ""

        val lines = file.readLines()
        val builder = StringBuilder()
        for (line in lines) {
            builder.append(line).append("<br>")
        }
        return builder.toString()
    }
}
