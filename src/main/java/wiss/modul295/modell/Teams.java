package wiss.modul295.modell;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@NoArgsConstructor
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float vermögen;
    private String trainer;
    private String name;

    public Teams(int id, float vermögen, String trainer,String name) {
        this.id = id;
        this.vermögen = vermögen;
        this.trainer = trainer;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVermögen() {
        return vermögen;
    }

    public void setVermögen(float vermögen) {
        this.vermögen = vermögen;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

