package com.example.meeting_15_spring.controllers;

import com.example.meeting_15_spring.models.Contact;
import com.example.meeting_15_spring.models.ImageCar;
import com.example.meeting_15_spring.repositories.AboutRepository;
import com.example.meeting_15_spring.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private AboutRepository aboutRepository;
    @Autowired
    private ContactsRepository contactsRepository;
    @GetMapping("/")
    public String getHome(@RequestParam(name = "text", required = false, defaultValue = "INTRODUCTION")String text,
                          Model model){
        String str = "My fascination with automobiles goes beyond mere transportation. " +
                "It's the raw power, precision engineering, and exhilarating speed of high-performance vehicles " +
                "that have consistently held my attention. The symphony of a roaring engine, the seamless acceleration, " +
                "and the marriage of cutting-edge technology with automotive artistry—these are the qualities that make " +
                "me a passionate enthusiast of powerful and fast cars. " +
                "My website offers a captivating journey through the fascinating world of high-performance cars. " +
                "You'll explore the remarkable stories, groundbreaking innovations, " +
                "and thrilling legacies that define these extraordinary vehicles. " +
                "It's more than just a glimpse into the past; it's an immersive experience into the heart " +
                "and soul of powerful and fast cars.";
        model.addAttribute("text", str);
        model.addAttribute("introduction", text);
        return "home";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        String str = "Sport cars are a thrilling and alluring category of automobiles that have captivated the hearts " +
                "of automotive enthusiasts for generations. These high-performance vehicles are celebrated for their " +
                "powerful engines, agile handling, and sleek, aerodynamic designs, making them the embodiment of speed " +
                "and precision on the road.\n" +
                "\n" +
                "The history of sport cars dates back to the early 20th century when the automotive industry was still " +
                "in its infancy. The very concept of a sport car emerged with the desire to create faster, more agile, " +
                "and more exhilarating vehicles for both racing and daily use. While the specific origins may be " +
                "debated, the early 20th century saw the development of sporty, lightweight cars with powerful engines, " +
                "often modified for racing, which laid the foundation for what we now recognize as sport cars.\n" +
                "\n" +
                "Sport cars have always held a special place in the hearts of enthusiasts for several reasons. Firstly, " +
                "they offer unparalleled performance with high-speed capabilities and impressive acceleration. " +
                "These cars are designed to deliver an exhilarating driving experience, whether on the racetrack " +
                "or winding back roads. They provide a sense of freedom and connection between driver and machine that few other vehicles can match.\n" +
                "\n" +
                "Furthermore, sport cars are admired for their eye-catching designs and aerodynamic profiles. " +
                "They often boast aggressive, low-slung shapes that not only enhance their visual appeal " +
                "but also improve handling and reduce air resistance. Their aesthetic appeal is a significant " +
                "part of their allure, and the innovative designs of sport cars have influenced the broader " +
                "automotive industry.\n" +
                "\n" +
                "Additionally, sport cars are at the forefront of automotive technology, often pioneering " +
                "advancements in engine performance, suspension systems, and braking technology. " +
                "These innovations eventually find their way into more mainstream vehicles, " +
                "contributing to the overall progress of the automotive industry.\n" +
                "\n" +
                "Finally, sport cars have a rich history in motorsports. Many iconic racing events, such as Formula 1, " +
                "Le Mans, and the Indianapolis 500, have featured sport cars as a central component. " +
                "These cars compete at the highest levels of motorsport, showcasing their capabilities " +
                "and pushing the boundaries of what is possible in terms of speed and agility.\n" +
                "\n" +
                "In conclusion, sport cars have a storied and fascinating history, " +
                "dating back to the early 20th century. Their enduring appeal lies in their unmatched performance, " +
                "captivating designs, technological innovation, and rich motorsport heritage. " +
                "Whether you're an automotive enthusiast or simply appreciate the thrill of high-speed driving, " +
                "sport cars continue to be a source of fascination and excitement for people all around the world.";
        Iterable<ImageCar> iterable = aboutRepository.findAll();
        model.addAttribute("sportCars", iterable);
        model.addAttribute("name", str);
        return "about";
    }

    @GetMapping("/contacts")
    public String getContacts(Model model){
        Iterable<Contact> iterable = contactsRepository.findAll();
        model.addAttribute("contacts", iterable);
        return "contacts";
    }
}
