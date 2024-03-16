package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
//Declaracion de variables
    private Integer id;
    private Integer numeroDocumento;
    private String tipoDocumento;
    private String nombre;
    private String direccionFisica;
    private String direccionElectronica;
    private Integer telefono;
    private String ciudad;
    private String clave;
    private String login;
    private String nacionalidad;
    private String departamento;
    private String codigoPostal;

//Cosntructor
    public Usuario( Integer id, Integer numeroDocumento, String tipoDocumneto, String nombre, String direccionFisica, String direccionElectronica, Integer telefono, String ciudad,
                     String clave, String login, String nacionalidad, String departamneto, String codigoPostal)
        {
        
        this.id=id;
        this.numeroDocumento=numeroDocumento;
        this.nombre=nombre;
        this.direccionFisica=direccionFisica;
        this.direccionElectronica=direccionElectronica;
        this.telefono=telefono;
        this.ciudad=ciudad;
        this.clave=clave;
        this.login=login;
        this.nacionalidad=nacionalidad;
        this.departamento=departamneto;
        this.codigoPostal=codigoPostal;
        }
//Constructor vacio
        public Usuario()
        {;}
//Getters y Setters
        public Integer getId() {
            return id;
        }
        public Integer getNumeroDocumento() {
            return numeroDocumento;
        }
        public String getTipoDocumento() {
            return tipoDocumento;
        }
        public String getNombre() {
            return nombre;
        }
        public String getDireccionFisica() {
            return direccionFisica;
        }
        public String getDireccionElectronica() {
            return direccionElectronica;
        }
        public Integer getTelefono() {
            return telefono;
        }
        public String getCiudad() {
            return ciudad;
        }
        public String getClave() {
            return clave;
        }
        public String getLogin() {
            return login;
        }
        public String getNacionalidad() {
            return nacionalidad;
        }
        public String getDepartamento() {
            return departamento;
        }
        public String getCodigoPostal() {
            return codigoPostal;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public void setNumeroDocumento(Integer numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
        }
        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setDireccionFisica(String direccionFisica) {
            this.direccionFisica = direccionFisica;
        }
        public void setDireccionElectronica(String direccionElectronica) {
            this.direccionElectronica = direccionElectronica;
        }
        public void setTelefono(Integer telefono) {
            this.telefono = telefono;
        }
        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }
        public void setClave(String clave) {
            this.clave = clave;
        }
        public void setLogin(String login) {
            this.login = login;
        }
        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }
        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }
        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }        

}
