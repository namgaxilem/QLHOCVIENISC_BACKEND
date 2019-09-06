package vn.team06.qlhocvienisc.controller;

import vn.team06.qlhocvienisc.service.ResponseMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/doc")
public class DocumentController {
    private static String UPLOADED_FOLDER = "D://PC//ISC//download//QLHOCVIENISC_FRONTEND_ADMIN//images//avatars//";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody ResponseMetadata handleFileUpload(@RequestParam(value="file") MultipartFile file) throws IOException {
    	if (file.isEmpty()) {
            System.out.println("Vui long chon file!");
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
    	return null;
    }

}
