package com.jaymansmann;

import com.jaymansmann.controller.Controller;
import com.jaymansmann.io.*;
import com.jaymansmann.io.save.file.LocalSaveService;
import com.jaymansmann.io.save.file.SaveService;
import com.jaymansmann.model.Model;
import com.jaymansmann.view.View;
import com.jaymansmann.view.output.FancyHospitalOutputService;
import com.jaymansmann.view.output.HospitalOutputFactory;
import com.jaymansmann.view.output.PlainHospitalOutputService;

public class Project2MVC {
    public static void main(String[] args) {

        /*
         * Singleton Pattern: Jsonifier class is a Singleton. Anyone can get that instance and invoke its methods.
         *   Why? I thought ObjectMapper might be an expensive object to create, so it's only be created if and when someone needs it.
         *
         * Observer Pattern: The View (the part of my code that deals with user input and output) observes the Model (the part of my code that deals with data)
         *   AND the LocalSaveService observes the Model
         *   Why? Whenever data changes, I want it to be saved, and I want the user to be alerted to the update
         *
         * Composite Pattern: The HealthcareProvider interface allows for the Composite Pattern. (HospitalManager -> Hospital -> Department -> Doctor)
         *   Why? I can easily tell my HospitalManager to treat a patient.
         *     It just tells the Hospital to treat that patient.
         *     The Hospital just tells its Departments to treat that patient.
         *     The Departments just tell the Doctors to treat that patient.
         *     If they don't have the patient, they just do nothing.
         *     If they do have the patient, they can treat them and release them.
         *  AND I can easily search my system for a Patient.
         *     I can ask my HospitalManager if it has a patient.
         *     It asks the Hospital if it has that patient.
         *     It can ask its Departments
         *     etc.
         *
         * Factory: The HospitalOutputFactory is a factory. It returns a HospitalOutputService (an interface implemented by classes that want to display the Hospital's JSON to the user).
         *   Why? There are lots of ways to display the data to the user.
         *     I could display it as a single line string of JSON
         *     I could display it as a pretty-printed JSON string
         *     I could display it nicely tabbed and indented and not JSON
         *     I could display it as HTML even
         *     So far, I've only implemented the pretty-printed part.
         *   AND I don't want the View class to have to worry too much about the details of that.
         *
         * Facade: The Jsonifier is a Facade over Jackon's ObjectMapper.
         *   Why? ObjectMapper is really complex and has a thousand methods. I don't really want all that complexity.
         *
         * AND ConsoleUserInputService is a facade over Scanner.
         * AND SaveService/LocalSaveService is a facade over all the file packages in Java
         *
         * Adaptor: Not yet
         */
        UserOutputService userOutputService = new ConsoleUserOutputService(); // TERMINAL
//         UserOutputService userOutputService = new SimpleSwingUserOutputService(); // SWING
//         try (UserInputService userInputService = new SimpleSwingUserInputService();) { // SWING
        try (UserInputService userInputService = new ConsoleUserInputService(userOutputService)) { // TERMINAL
            HospitalOutputFactory hospitalOutputFactory = new HospitalOutputFactory(new PlainHospitalOutputService(), new FancyHospitalOutputService());
            SaveService saveService = new LocalSaveService(userOutputService);
            Model model = new Model();
            Controller controller = new Controller(model);
            View view = new View(userInputService, userOutputService, controller, hospitalOutputFactory);
            model.addObserver(saveService);
            model.addObserver(view);

            model.start(saveService.read());
        } catch (Exception e) {
            userOutputService.displayErrorText(e.getMessage());
        }
    }
}
