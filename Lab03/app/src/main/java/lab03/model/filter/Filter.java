package lab03.model.filter;

import java.util.List;

import lab03.model.Evento;

public interface Filter {
   public List<Evento> filter(List<Evento> eventos);
}