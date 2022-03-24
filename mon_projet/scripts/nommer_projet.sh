# Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
#
# This file is part of aquiletour
#
# aquiletour is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# aquiletour is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

##### INCLUDE #####
this_dir=$(readlink -f $0)
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

save_dir

cd "$root_dir"

echo "Saisir le nom du paquet désiré: "

read nom_paquet

echo "Vous avez saisi '$nom_paquet', est-ce ok? [Oui/Non]"

read reponse

if [ "$reponse" == "" -o "$reponse" == "O" -o "$reponse" == "Oui" -o "$reponse" == "o" ]; then

    echo "Renommage 'mon_jeu' à '$nom_paquet'"

    sed "s/mon_jeu/$nom_paquet/g" -i settings.gradle
    sed "s/mon_jeu/$nom_paquet/g" -i gradle.properties

    find . -type f -name "*.xml" | while read i; do sed "s/mon_jeu/$nom_paquet/" -i "$i"; done

    grep -Rl "package mon_jeu" *  | while read i; do sed "s/package mon_jeu/package $nom_paquet/g" -i "$i"; done
    grep -Rl "import mon_jeu" *  | while read i; do sed "s/import mon_jeu/import $nom_paquet/g" -i "$i"; done

    find . -type d -name mon_jeu | sort -r | while read i; do mv "$i" $(dirname "$i")/$nom_paquet; done

else

    echo "[ERREUR] rien n'est fait. SVP réessayer"

fi


restore_dir

