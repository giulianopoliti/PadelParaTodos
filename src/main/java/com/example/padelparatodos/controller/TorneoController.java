package com.example.padelparatodos.controller;

import com.example.padelparatodos.entity.CategoriaEntity;
import com.example.padelparatodos.entity.JugadorEntity;
import com.example.padelparatodos.model.ParejaDTO;
import com.example.padelparatodos.model.partido.Partido;
import com.example.padelparatodos.model.partido.PartidoDTO;
import com.example.padelparatodos.model.torneo.Torneo;
import com.example.padelparatodos.model.Zona;
import com.example.padelparatodos.model.Pareja;
import com.example.padelparatodos.service.CategoriaService;
import com.example.padelparatodos.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/torneo")
public class TorneoController {
    private final JugadorService jugadorService;
    private final CategoriaService categoriaService;
    private Torneo torneo;
    @Autowired
    public TorneoController(JugadorService jugadorService, CategoriaService categoriaService) {
        this.jugadorService = jugadorService;
        this.categoriaService = categoriaService;
    }

    private HashMap<Integer, Pareja> ordenarParejas(HashMap<Integer, Pareja> zonas) {
        // Convertir el HashMap en una lista de entradas (pares clave-valor)
        List<Map.Entry<Integer, Pareja>> list = new ArrayList<>(zonas.entrySet());

        // Ordenar la lista de entradas en función de la suma de los puntajes de los jugadores
        list.sort((entry1, entry2) -> {
            Pareja pareja1 = entry1.getValue();
            Pareja pareja2 = entry2.getValue();

            int score1 = pareja1.getJugador1().getScore() + pareja1.getJugador2().getScore();
            int score2 = pareja2.getJugador1().getScore() + pareja2.getJugador2().getScore();

            return Integer.compare(score2, score1); // Orden descendente
        });

        // Crear un LinkedHashMap para mantener el orden de las parejas ordenadas
        HashMap<Integer, Pareja> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Pareja> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    @PostMapping("/crear")
    public void crearTorneo (@RequestBody Map<String, Object> request) {
        Map<String, Map<String, Map<String, Object>>> parejasDTO = (Map<String, Map<String, Map<String, Object>>>) request.get("parejas");
        HashMap<Integer, Pareja> parejas = new HashMap<>();
        Integer idCategoria = (Integer) request.get("idCategoria");
        int count = 0;
        Set<JugadorEntity> jugadoresRegistrados = new HashSet<>(); // Conjunto para verificar jugadores registrados
        for (Map.Entry<String, Map<String, Map<String, Object>>> entry: parejasDTO.entrySet()) {
            String parejaKey = entry.getKey();
            Map<String, Map<String, Object>> parejaData = entry.getValue();
            JugadorEntity jugadorEntity1 = jugadorService.findByNameAndLastName((String)entry.getValue().get("jugador1").get("name"), (String)entry.getValue().get("jugador1").get("lastName"));
            JugadorEntity jugadorEntity2 = jugadorService.findByNameAndLastName((String)entry.getValue().get("jugador2").get("name"), (String)entry.getValue().get("jugador2").get("lastName"));
            if (jugadoresRegistrados.contains(jugadorEntity1) || jugadoresRegistrados.contains(jugadorEntity2)) {
                throw new RuntimeException("Error, un jugador ya esta registrado.");
            }
            jugadoresRegistrados.add(jugadorEntity1);
            jugadoresRegistrados.add(jugadorEntity2);
            parejas.put(count,new Pareja(jugadorEntity1,jugadorEntity2));
            count++;
        }
        parejas = ordenarParejas(parejas);
        CategoriaEntity categoriaEntity = categoriaService.buscarCategoria(idCategoria);
        this.torneo = new Torneo(parejas,categoriaEntity,null);
    }
    @PostMapping("/zonas/crear")
    public void createZones (@RequestParam int sizeOfMatchs) {
        this.torneo.crearZonas(sizeOfMatchs);
    }

    @GetMapping ("/zonas/get")
    public List<Zona> getTorneo () {
        return this.torneo.getZonas();
    }
    @PostMapping ("zonas/partidos/crear")
    public void createMatchs () {
        this.torneo.createMatchsOfZone();
    }
    @GetMapping("/zonas/partidos/get")
    public HashMap<Integer, List<PartidoDTO>> getPartidosOfZones () {
        HashMap<Integer, List<PartidoDTO>> partidos = new HashMap<>();
        for (int i = 0; i < this.torneo.getZonas().size(); i++) {
            List<PartidoDTO> partidosDTOs = new ArrayList<>();
            for (int j = 0; j < this.torneo.getZonas().get(i).getPartidos().size(); j++) {
                partidosDTOs.add(j, this.torneo.getZonas().get(i).getPartidos().get(j).partidoToDTO());
            }
            partidos.put(i,partidosDTOs);
        }
        return partidos;
    }
    @GetMapping("/size")
    public Integer getSizeOfMatchs () {
        return this.torneo.getZonas().get(0).getSizeOfMatchs();
    }

    /*
    @PostMapping("/crear")
    public HashMap<Integer, Pareja> crearTorneo(@RequestBody Map<String,Object> request) {
        // Aca extraemos los datos de la Request
        HashMap<Integer, ParejaDTO> = jugadorService.buscarJugador((JugadorEntity) request.get("parejas"));
        HashMap<Integer, JugadorDTO> jugadores =
        CategoriaEntity categoriaEntity = categoriaService.buscarCategoria(idCategoria);
        System.out.println(categoriaEntity.getNameCategory());
        Categoria categoria = new Categoria(categoriaEntity);
        List<Zona> zonas = new ArrayList<>();
        Torneo torneo = new Torneo(parejas, categoria, zonas);
        torneo.crearZonas();
        return torneo.getJugadores();
    }*/

    public Pareja crearPareja (JugadorEntity jugador1, JugadorEntity jugador2) {
        return new Pareja(jugador1,jugador2);
    }

    public void setearResultadoPartido (@RequestBody Map<String, Object> request) {

    }
}
