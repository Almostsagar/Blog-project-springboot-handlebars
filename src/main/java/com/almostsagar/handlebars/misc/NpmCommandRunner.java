package com.almostsagar.handlebars.misc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class NpmCommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("npm", "run", "build:css");
            processBuilder.directory(new java.io.File("E:\\vscode-workspace\\handlebars.blog")); // Update with the
                                                                                                 // correct path
            Process process = processBuilder.start();

            // Capture output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
