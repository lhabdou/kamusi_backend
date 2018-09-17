INSERT INTO public.role (id, nom_role) VALUES (1,'Administrateur');

INSERT INTO public.utilisateur (id_utilisateur, nom, prenom, pseudo, email) VALUES (
1, 'SOILIHI', 'Abdoulhalim', 'Lhabdou', 'lhabdou26@hotmail.fr');

INSERT INTO public.statut (id_statut, statut) VALUES (1,'Nouveau'); 



INSERT INTO public.dictionnaire(
            mot_fr, mot_ngz, mot_ndz, mot_mwa, mot_mao, mot_ang, id_utilisateur, 
            id_statut, suggestion, definition_fr, definition_com)
    VALUES ('Manger', 'Hula', 'Hula', 'Wuya', 'Hula', 'To Eat', 1, 
            1, NULL, 'Action de macher et avaler', 'Ndo wu trafougna bahindru mdrou ya mize'),
            ('Marcher', 'Hwenda', 'Tsendra', 'Hwendra', 'Hwendra', 'To Walk', 1, 
            1, NULL, 'Se déplacer à pied', 'Ndo wu badili makazi ha wurimiya yé mindou');
