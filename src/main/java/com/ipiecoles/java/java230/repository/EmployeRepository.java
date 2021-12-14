package com.ipiecoles.java.java230.repository;

import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    //Recherche d'employés par matricule
    Employe findByMatricule(String Matricule);

    //Recherche d'employés par nom et prénom
    List<Employe> findByNomAndPrenom(String nom, String prenom);

    //Recherche d'employés par nom sans prendre en compte la casse
    List<Employe> findByNomIgnoreCase (String nom);

    //Recherche d'employés embauchés avant une certaine date
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    //Recherche d'employés embauchés après une certaine date
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    //Recherche d'employés gagnant plus de X euros et ordonnés selon leur salaire (ceux qui gagnent le plus d'abord).
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    // Ajouter une méthode permettant de rechercher les employés en fonction de leur nom sans prendre en compte la casse, et ce de manière paginée.
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);

    //Ajouter une méthode findByNomOrPrenomAllIgnoreCase prenant en parametre un String nomOuPrenom
    //    et qui recherche sans prendre en compte la casse les employés ayant ce paramètre en nom ou en prénom. Utiliser @Param.


    //Ajouter une méthode findByNomOrPrenomAllIgnoreCase prenant en parametre un String nomOuPrenom
    //    et qui recherche sans prendre en compte la casse les employés ayant ce paramètre en nom ou en prénom. Utiliser @Param.
    @Query("select e from Employe e " +
            "where lower(e.prenom) = lower(:nomOuPrenom) or " +
            "lower(e.nom) = lower(:nomOuPrenom)")
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);


    //Ajouter une méthode findEmployePlusRiches qui récupère les employés dont le salaire est supérieur
    //    au salaire moyen des employés (voir requête SQL exo 13 du TP MySQL)
    @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
    List<Employe> findEmployePlusRiches();


}