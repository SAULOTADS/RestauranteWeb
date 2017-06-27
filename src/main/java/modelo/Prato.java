/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "prato", catalog = "vegetaurante", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prato.findAll", query = "SELECT p FROM Prato p"),
    @NamedQuery(name = "Prato.findByIdPrato", query = "SELECT p FROM Prato p WHERE p.idPrato = :idPrato"),
    @NamedQuery(name = "Prato.findByNome", query = "SELECT p FROM Prato p WHERE p.nome = :nome"),
    @NamedQuery(name = "Prato.findByDescricao", query = "SELECT p FROM Prato p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Prato.findByPreco", query = "SELECT p FROM Prato p WHERE p.preco = :preco"),
    @NamedQuery(name = "Prato.findByImgSopa", query = "SELECT p FROM Prato p WHERE p.imgSopa = :imgSopa")})
public class Prato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrato")
    private Integer idPrato;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @Size(max = 100)
    @Column(name = "imgSopa")
    private String imgSopa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<ItemPedido> itemPedidoList;

    public Prato() {
    }

    public Prato(Integer idPrato) {
        this.idPrato = idPrato;
    }

    public Integer getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(Integer idPrato) {
        this.idPrato = idPrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getImgSopa() {
        return imgSopa;
    }

    public void setImgSopa(String imgSopa) {
        this.imgSopa = imgSopa;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrato != null ? idPrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prato)) {
            return false;
        }
        Prato other = (Prato) object;
        if ((this.idPrato == null && other.idPrato != null) || (this.idPrato != null && !this.idPrato.equals(other.idPrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Prato[ idPrato=" + idPrato + " ]";
    }
    
}
