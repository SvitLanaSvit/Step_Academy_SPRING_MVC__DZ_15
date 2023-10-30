package com.example.meeting_15_spring.controllers;

import com.example.meeting_15_spring.models.Post;
import com.example.meeting_15_spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String getBlog(Model model){
        Iterable<Post> iterable = postRepository.findAll();
        model.addAttribute("posts", iterable);
        return "blog";
    }

    @GetMapping("/blog/newPost")
    public String getNewPost(Model model){
        return "newPost";
    }

    @PostMapping("/blog/newPost")
    public String getNewPostToPost(
            @RequestParam String context,
            @RequestParam String header,
            @RequestParam File linkImage,
            Model model) throws IOException {
        Post post = new Post();
        post.setContext(context);
        post.setHeader(header);
        String path = new ClassPathResource("static/").getPath() +linkImage.getName();
        try(
                var stream = new FileInputStream(linkImage.getAbsolutePath());
                var output = new FileOutputStream(path)
        )
        {
            output.write(stream.readAllBytes());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
//        File resourceDirectory = ResourceUtils.getFile("classpath:static");
//        String fileName = linkImage.getName();
//        Path filePath = Paths.get(resourceDirectory.getAbsolutePath(), fileName);
//        Files.copy(linkImage.toPath(), filePath);
        post.setLinkImage(linkImage.getName());
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/1")
    public String getBlog1(Model model){
        String title = "Bugatti Veyron";
        List<String> images = new ArrayList<>(
                List.of(
                        "https://www.amalgamcollection.com/cdn/shop/articles/DSCF3028_1024x1024.jpg?v=1648229397",
                        "https://newsroomcdn.bugatti.com/w_3200/s3-newsroom-bugatti/f29e9855-d2d0-401c-ab77-a9127d1ed25c.jpg",
                        "https://imgr1.auto-motor-und-sport.de/Bugatti-EB-16-4-Veyron-2001-jsonLd16x9-c5a20314-1687761.jpg"));
        String text = "The Bugatti Veyron is a high-performance sports car that was produced by the French automobile " +
                "manufacturer Bugatti from 2005 to 2015. It is known for its exceptional speed, power, " +
                "and engineering prowess. Here are some key details about the Bugatti Veyron: ";
        String txt_1 = "1. **Performance:** The Bugatti Veyron is renowned for its remarkable performance. " +
                "The original version, the Veyron 16.4, is powered by an 8.0-liter quad-turbocharged W16 engine, " +
                "which produces a staggering 1,001 metric horsepower (987 bhp) and 1,250 Nm (922 lb-ft) of torque. " +
                "This immense power enables the Veyron to accelerate from 0 to 60 mph in just 2.5 seconds and reach " +
                "a top speed of over 250 mph (400 km/h). ";
        String txt_2 = "2. **Variants:** The Veyron saw several different variants and limited editions during " +
                "its production run, including the Veyron 16.4 Grand Sport, Veyron 16.4 Super Sport, " +
                "and the Veyron 16.4 Grand Sport Vitesse. The Super Sport, in particular, held the title " +
                "of the world's fastest production car for several years, with a top speed of 267 mph (431 km/h).";
        String txt_3 = "3. **Design:** The Veyron features a distinctive and aerodynamically designed " +
                "body with a combination of curves and sharp lines. It was built with a focus on both " +
                "style and performance, resulting in a car that looks as stunning as it is fast.";
        String txt_4 = "4. **Engineering:** Bugatti invested heavily in engineering and technology " +
                "to create the Veyron. The car features a sophisticated all-wheel-drive system, " +
                "a seven-speed dual-clutch automatic transmission, and advanced aerodynamics to " +
                "maintain stability at high speeds.";
        String txt_5 = "5. **Production:** The Bugatti Veyron was produced in limited quantities due " +
                "to its high cost and complexity. Only 450 units of the Veyron 16.4 were produced, " +
                "making it a rare and exclusive supercar.";
        String txt_6 = "6. **Legacy:** The Veyron played a significant role in pushing the boundaries " +
                "of automotive engineering and redefining what was possible in terms of speed " +
                "and performance for a road-legal car. It became a symbol of extreme luxury and high-performance driving.";
        String txt_7 = "7. **Successor:** The Bugatti Veyron was succeeded by the Bugatti Chiron, " +
                "which was introduced in 2016. The Chiron continued the tradition of extreme performance " +
                "and was designed to be even faster and more powerful than its predecessor.";
        List<String> txts = new ArrayList<>(List.of(txt_1, txt_2, txt_3, txt_4, txt_5, txt_6, txt_7));
        String resume = "The Bugatti Veyron is often considered one of the most iconic and legendary supercars " +
                "in the history of automotive engineering, known for its incredible speed and precision engineering. " +
                "It remains a symbol of automotive excellence and a dream car for many enthusiasts.";

        model.addAttribute("title", title);
        model.addAttribute("images", images);
        model.addAttribute("text", text);
        model.addAttribute("txts", txts);
        model.addAttribute("resume", resume);

        return "blogInfo";
    }

    @GetMapping("/blog/2")
    public String getBlog2(Model model){
        String title = "Maybach Exalero";
        List<String> images = new ArrayList<>(
                List.of(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Excelero.jpg/1200px-Excelero.jpg",
                        "https://imgr1.auto-motor-und-sport.de/Maybach-Exelero-by-Khaled-Alkayed-169FullWidth-9f704e30-800162.jpg",
                        "https://auta5p.eu/katalog/maybach/exelero_01a.jpg"));
        String text = "As of my last knowledge update in January 2022, the Maybach brand primarily offered " +
                "luxury cars under the Mercedes-Maybach sub-brand. These vehicles are known for their opulence, " +
                "high-end features, and exceptional comfort. While I can't provide information on any new models " +
                "or developments that may have occurred after that date, I can offer some general information " +
                "about the Maybach brand and its notable models up to that point:";
        String txt_1 = "1. **Maybach Models:** Maybach 57 and 62: These were the first models reintroduced " +
                "under the revived Maybach brand. The numbers in the names referred to the lengths " +
                "of the vehicles in decimeters, with the Maybach 62 being the longer variant. " +
                "They were produced from the early 2000s until 2012.";
        String txt_2 = "2. **Mercedes-Maybach Models:** Mercedes-Maybach S-Class: " +
                "The Mercedes-Maybach S-Class is a line of ultra-luxury versions of the Mercedes-Benz S-Class sedan. " +
                "These cars featured extended wheelbases and premium amenities to cater to the most discerning customers. " +
                "They were available in various trims, including the Maybach S 560 and Maybach S 650.";
        String txt_3 = "3. **Concept Cars:** Maybach had also showcased various concept cars to demonstrate their " +
                "vision of the future of luxury automobiles. One notable concept was the Mercedes-Maybach Vision 6, " +
                "an electric coupe with striking design elements and advanced technology.";
        List<String> txts = new ArrayList<>(List.of(txt_1, txt_2, txt_3));
        String resume = "Please note that the specific Maybach lineup and models may have evolved or expanded " +
                "since last update. To get the latest information about Maybach's current offerings, " +
                "I recommend visiting the official Mercedes-Maybach website or contacting a Mercedes-Benz dealership.";

        model.addAttribute("title", title);
        model.addAttribute("images", images);
        model.addAttribute("text", text);
        model.addAttribute("txts", txts);
        model.addAttribute("resume", resume);

        return "blogInfo";
    }

    @GetMapping("/blog/3")
    public String getBlog3(Model model){
        String title = "Pagani Huayre Tricolore";
        List<String> images = new ArrayList<>(
                List.of(
                        "https://cdn.motor1.com/images/mgl/42n9J/s1/pagani-huayra-tricolore.jpg",
                        "https://i.auto-bild.de/ir_img/2/6/9/9/0/7/5/Pagani-Huayra-Roadster-BC-560x373-fb5b336e265da556.jpg",
                        "https://top-tuning.ru/upload/images/news/105920/pagani_huayra_4.jpg"));
        String text = "The Pagani Huayra Tricolore is a limited-edition hypercar produced by the Italian automaker Pagani. " +
                "It was unveiled in 2021 to commemorate the 60th anniversary of the Frecce Tricolori, " +
                "the aerobatic demonstration team of the Italian Air Force. Here are some key details " +
                "about the Pagani Huayra Tricolore:";
        String txt_1 = "1. **Design:** The Huayra Tricolore features a unique and aerodynamically optimized design, " +
                "with inspiration drawn from fighter jets. It sports a blue-tinted carbon fiber body, white accents, " +
                "and the colors of the Italian flag, symbolizing the Frecce Tricolori. The car's design is " +
                "a blend of art and engineering, showcasing Pagani's commitment to craftsmanship and attention to detail.";
        String txt_2 = "2. **Power:** Under the hood, the Huayra Tricolore is powered by a 6.0-liter, " +
                "twin-turbocharged V12 engine developed by Mercedes-AMG. It produces 829 horsepower " +
                "and 811 lb-ft of torque, sending power to the rear wheels through " +
                "a 7-speed automated manual transmission.";
        String txt_3 = "3. **Performance:** With its powerful engine and lightweight construction, " +
                "the Huayra Tricolore is capable of impressive performance. It can accelerate from 0 to 60 mph " +
                "in around 3 seconds and has a top speed of approximately 230 mph (370 km/h).";
        String txt_4 = "4. **Aerodynamics:** The car features advanced aerodynamics, including a large front splitter, " +
                "active flaps, and a rear wing that can be adjusted to optimize downforce and stability at high speeds. " +
                "These elements help the car maintain control and performance during aggressive driving.";
        String txt_5 = "5. **Interior:** The interior of the Huayra Tricolore is a blend of luxury and high-tech features. " +
                "It features fine leather, aluminum accents, and a prominent touchscreen infotainment system. " +
                "The seats are designed to offer comfort and support during high-speed driving.";
        String txt_6 = "6. **Limited Edition:** As with many Pagani models, the Huayra Tricolore is produced " +
                "in very limited numbers. Only three units of this special edition hypercar were manufactured, " +
                "making it an exclusive and highly sought-after collector's item.";
        String txt_7 = "7. **Price:** The Pagani Huayra Tricolore is an extremely high-end hypercar, " +
                "and the price tag reflects its exclusivity and craftsmanship. " +
                "It is one of the most expensive and rare vehicles in the world.";
        List<String> txts = new ArrayList<>(List.of(txt_1, txt_2, txt_3, txt_4, txt_5, txt_6, txt_7));
        String resume = "The Pagani Huayra Tricolore represents the pinnacle of Italian hypercar craftsmanship " +
                "and is a tribute to the Italian Air Force's aerobatic team. The combination of exquisite design, " +
                "powerful performance, and limited production numbers makes it a highly coveted vehicle among " +
                "automotive enthusiasts and collectors.";

        model.addAttribute("title", title);
        model.addAttribute("images", images);
        model.addAttribute("text", text);
        model.addAttribute("txts", txts);
        model.addAttribute("resume", resume);

        return "blogInfo";
    }
}
