package co.edu.unbosque.workshop5.servlet.pojo;

public class VisitPOJO {

    private Integer visitId;
    private String createdAt;
    private String type;
    private String description;
    private String vetId;
    private Integer petId;

    public VisitPOJO(){}

    public VisitPOJO(Integer visitId, String createdAt, String type,String description, String vetId, Integer petId) {
        this.visitId = visitId;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.vetId = vetId;
        this.petId = petId;
    }

    public VisitPOJO(String createdAt, String type, String description) {
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }
}
