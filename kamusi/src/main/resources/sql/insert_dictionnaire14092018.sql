INSERT INTO public.role (id, nom_role) VALUES (1,'ADMINISTRATEUR'),(2,'VALIDEUR'),(3,'CONTRIBUTEUR'),(4,'INVITE');

INSERT INTO public.utilisateur (id_utilisateur, nom, prenom, pseudo, email, id_role) VALUES ('6xhd95Kx3NPkVXKbfuh1LZYFMt83', 'SOILIHI', 'Abdoulhalim', 'Lhabdou', 'lhabdou26@hotmail.fr',1);

INSERT INTO public.statut (id_statut, statut) VALUES (1,'NOUVEAU'),(2,'A VALIDER'),(3,'VALIDE'), (4,'CLOTURE'); 



INSERT INTO public.dictionnaire(
            mot_fr, mot_ngz, mot_ndz, mot_mwa, mot_mao, mot_ang, id_utilisateur, 
            id_statut, suggestion, definition_fr, definition_com)
    VALUES ('Manger', 'Hula', 'Hula', 'Wuya', 'Hula', 'To Eat', '6vDIgub6NOc7p6dJfvmvVWaTQE73', 
            1, NULL, 'Action de macher et avaler', 'Ndo wu trafougna bahindru mdrou ya mize'),
            ('Marcher', 'Hwenda', 'Tsendra', 'Hwendra', 'Hwendra', 'To Walk', '6vDIgub6NOc7p6dJfvmvVWaTQE73', 
            1, NULL, 'Se déplacer à pied', 'Ndo wu badili makazi ha wurimiya yé mindou');

