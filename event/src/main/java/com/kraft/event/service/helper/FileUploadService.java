package com.kraft.event.service.helper;

import com.kraft.event.exception.FileExtensionNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


@Service
public class FileUploadService {

    public final Function<MultipartFile,String > uploadFile = (multipartFile) ->{
        var fileName = multipartFile.getOriginalFilename();
        try{
            var location = Paths.get("src/main/resources/static/files").toAbsolutePath().normalize();
            if(!Files.exists(location)){
                Files.createDirectories(location);
            }
            assert fileName != null;
            var filePath = location.resolve(fileName);
            Files.copy(multipartFile.getInputStream(),filePath,REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public final Function<String ,String > fileExtension = (fileName) -> Optional.of(fileName)
            .filter(f->f.contains("."))
            .map(name -> "." + name.substring(name.lastIndexOf(".")+1))
            .orElseThrow(()->new FileExtensionNotFoundException("This file is not provided with file extension."));
}
