package se.artcomputer.edu.spring.boot.demo.fileupload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FileUploadPage {

    @GetMapping("/upload")
    public String page() {
        return "<html> <body>" +
                "<form method=\"POST\" enctype=\"multipart/form-data\" action=\"/upload\">" +
                "<table>" +
                "<tr><td>File to upload:</td><td><input type=\"file\" name=\"file\" />" +
                "</td></tr>" +
                "<tr><td></td><td><input type=\"submit\" value=\"Upload\" /></td></tr>" +
                "</table>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        //storageService.store(file);
        String message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        redirectAttributes.addFlashAttribute("message",message);

        return message; // "redirect:/" Not working
    }
}
