package wiss.modul295.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiss.modul295.exceptions.SpielException;
import wiss.modul295.modell.Spiel;
import wiss.modul295.modell.SpielRepository;


import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;


@RestController // This means that this class is a Controller
    @RequestMapping(path="/spiel") // This means URL's start with /demo (after Application path)
    public class SpielController {

        @Autowired
        private SpielRepository spielRepository;


        @PostMapping(path="/add") // Map ONLY POST Requests
        public String addNewSpiel (@RequestParam int spiel_tore) {
            try {
                Spiel c = new Spiel();
                c.setSpiel_tore(spiel_tore);
                spielRepository.save(c);
                return "Saved";
            } catch (Exception e) {
                return "There is something wrong";
            }
        }

        @GetMapping(path="/")
        public ResponseEntity<Iterable<Spiel>> getAllSpiel() throws SpielException {
            Iterable<Spiel> spiel = null;

            try{
                spiel = spielRepository.findAll();
            } catch (Exception e) {
                throw new SpielException();
            }
            return ResponseEntity.ok(spiel);
        }

        @PutMapping(path = "/update")
        public String updateSpiel (@QueryParam("id") int id,
                                 @FormParam("spiel_tore")int spiel_tore){
            try {
                Spiel spiel = spielRepository.findById(id).get();
                spiel.setSpiel_tore(spiel_tore);
                spielRepository.save(spiel);
                return "Updated";
            } catch (Exception e){
                return "There is something wrong";
            }
    }

        @DeleteMapping(path = "/delete")
        public String deleteOldSpiel (@RequestParam int id) {
            try {
                spielRepository.deleteById(id);
                return "Deleted";
            } catch (Exception e){
                return "There is something wrong";
            }
        }
    }


