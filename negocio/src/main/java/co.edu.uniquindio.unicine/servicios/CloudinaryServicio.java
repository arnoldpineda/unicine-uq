package co.edu.uniquindio.unicine.servicios;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServicio {

    private Cloudinary cloudinary;
    private Map<String, String> config;

    public CloudinaryServicio (){
        config = new HashMap<>();
        config.put("cloud_name", "dxxnmfobn");
        config.put("api_key", "383622191148957");
        config.put("api_secret", "VgVCWDG0sl5UA7zxUI23FqEgaXA");

        cloudinary = new Cloudinary(config);
    }

    public Map subirImagen(File file, String carpeta) throws Exception {
        Map respuesta = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", String.format("unicine/%s", carpeta)));
        return  respuesta;
    }
    public Map eliminarImagen(String idImagen) throws Exception {
        Map respuesta = cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
        return  respuesta;
    }
}
