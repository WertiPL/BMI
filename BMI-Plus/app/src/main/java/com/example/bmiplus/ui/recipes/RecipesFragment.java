package com.example.bmiplus.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmiplus.databinding.FragmentRecipesBinding;

import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends Fragment {

    private FragmentRecipesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecipesViewModel notificationsViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ArrayList<recipe> recipes = new ArrayList<recipe>();

        recipes.add(1,new recipe("Kasza bulgur z warzywami i fasolką","\n" +
                "\n" +
                "    Na głębokiej patelni (takiej z pokrywą) lub w szerokim garnku, na maśle i oliwie zeszklić pokrojoną w kosteczkę cebulę. Dodać rozgniecione ząbki czosnku i chwilę razem podsmażyć.\n" +
                "    Dodać pokrojoną w kostkę paprykę i mieszając co chwilę smażyć przez około 2 minuty.\n" +
                "    Wsypać suchą kaszę bulgur i podsmażać przez ok. 1 minutę mieszając. Dodać słodką paprykę w proszku, kurkumę oraz kumin.\n" +
                "    Wlać gorący bulion i zagotować, dodać fasolkę z puszki wraz z zalewą, pomidory z puszki, wymieszać i całość zagotować na dużym ogniu. Doprawić solą i pieprzem.\n" +
                "    Przykryć pokrywą, zmniejszyć ogień i gotować przez 15 minut, w międzyczasie po 10 minutach gotowania dodać cukinię pokrojoną w słupki lub kosteczkę, wymieszać, przykryć i dalej gotować przez ostatnie 5 minut.\n" +
                "    Dodać sos ostrygowy i ciągle mieszając zagotować. Następnie dodać szpinak, wymieszać i podgrzewać przez chwilę aż zwiędnie. Można podawać samodzielnie lub z poniższymi dodatkami.\n" +
                "\n" +
                "Propozycja podania\n" +
                "\n" +
                "    pokrojone awokado, skropione cytryną i posypane listkami kolendry\n" +
                "    tarty ser\n" +
                "\n"," 1/2 cebuli\n" +
                "po 1/2 łyżki masła i oliwy\n" +
                "2 ząbki czosnku\n" +
                "1 papryka\n" +
                "100 g kaszy bulgur\n" +
                "przyprawy: sól, pieprz, 2 łyżeczki słodkiej papryki, 1/2 łyżeczki kurkumy, 1/2 łyżeczki kuminu (kminu rzymskiego)\n" +
                "1 szklanka bulionu\n" +
                "1 puszka białej fasolki\n" +
                "1 puszka krojonych pomidorów*\n" +
                "1/3 cukinii\n" +
                "1 łyżka sosu ostrygowego\n" +
                "2 garście szpinaku (ok. 100 g"));

        recipes.add(2,new recipe("Filet pieczony w rękawie z ziemniakami i marchewką","1\n" +
                "\n" +
                "Ziemniaki, marchewkę i cebulę obieramy i kroimy na mniejsze kawałki. Jeżeli ziemniaki są małe pozostawiamy je w całości. Warzywa polewamy oliwą i doprawiamy solą, pieprzem i rozmarynem.\n" +
                "2\n" +
                "\n" +
                "W misce łączymy dwie łyżki musztardy, dwie łyżki miodu, 100ml oliwy, łyżeczkę soli, łyżeczkę pieprzu i dwie łyżeczki słodkiej papryki w proszku.\n" +
                "W przygotowanej marynacie umieszczamy filety z kurczaka i marynujemy w lodówce  przez kilka godzin.\n" +
                "3\n" +
                "\n" +
                "W rękawie kuchennym umieszczamy warzywa i mięso. Po zawiązaniu rękawa robimy w nim nożem  kilka dziurek.\n" +
                "Pieczemy przez godzinę w 180 stopniach.\n" +
                "Smacznego!","    1 kg ziemniaków\n" +
                "    1 kg marchewki\n" +
                "    3 cebule\n" +
                "    4 filety z piersi kurczaka\n" +
                "    oliwa\n" +
                "    rozmaryn\n" +
                "    słodka papryka w proszku\n" +
                "    sól\n" +
                "    pieprz\n" +
                "    miód\n" +
                "    musztarda"));




        final TextView textView = binding.textRecipes123;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}