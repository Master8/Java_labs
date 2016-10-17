package com.michael.servlet;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@WebServlet("/decode")
public class DecoderServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String src = req.getParameter("src");

        byte[] buffer = Base64.decodeBase64(src);
        byte[] rezultBuffer = new byte[100];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        XZCompressorInputStream compressorInputStream = new XZCompressorInputStream(inputStream);

        compressorInputStream.read(rezultBuffer);
        compressorInputStream.close();

        String result = new String(rezultBuffer);

        req.setAttribute("result", result);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
