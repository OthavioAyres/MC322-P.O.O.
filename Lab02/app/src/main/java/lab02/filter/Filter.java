package lab02.filter;

import java.util.List;

import lab02.Evento;

public interface Filter {
   public List<Evento> filter(List<Evento> eventos);
}