package wiss.modul295.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiss.modul295.exceptions.SpielerException;
import wiss.modul295.modell.Spieler;
import wiss.modul295.modell.SpielerRepository;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;


@RestController
    @RequestMapping(path="/spieler")
    public class SpielerController {

        @Autowired
        private SpielerRepository spielerSRepository;


        @PostMapping(path="/add")
        public String addNewSpieler (@RequestParam String spieler_name,String vorname,int nummer,int tore) {

            try {
                Spieler c = new Spieler();
                c.setName(spieler_name);
                c.setVorname(vorname);
                c.setSpielernummer(nummer);
                c.setSpielertore(tore);
                spielerSRepository.save(c);
                return "Saved";
            } catch (Exception e){
                return "There is something wrong";
            }
        }

        @GetMapping(path="/")
        public ResponseEntity<Iterable<Spieler>> getAllSpieler() throws SpielerException {
            Iterable<Spieler> spieler = null;

            try{
                spieler = spielerSRepository.findAll();
            } catch (Exception e) {
                throw new SpielerException();
            }
            return ResponseEntity.ok(spieler);
        }

        @PutMapping(path = "/update")
        public String updateSpieler (@QueryParam("id") int id,
                                     @FormParam("spieler_name")String spieler_name,
                                     @FormParam("vorname")String vorname,
                                     @FormParam("nummer")int nummer,
                                     @FormParam("tore")int tore){
            try {
                Spieler spieler = spielerSRepository.findById(id).get();
                spieler.setSpielertore(tore);
                spieler.setSpielernummer(nummer);
                spieler.setName(spieler_name);
                spieler.setVorname(vorname);
                spielerSRepository.save(spieler);
                return "Updated";
            } catch (Exception e){
                return "There is something wrong";
            }
        }


        @DeleteMapping(path = "/delete")
        public String deleteOldSpieler (@RequestParam int id) {
            try {
                spielerSRepository.deleteById(id);
                return "Deleted";
            } catch (Exception e){
                return "There is something wrong";
            }
        }
}
