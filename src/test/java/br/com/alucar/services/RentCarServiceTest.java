package br.com.alucar.services;

import br.com.alucar.domain.entities.RentCar;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.helper.RentCarHelper;
import br.com.alucar.repositories.RentCarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RentCarServiceTest {

    @InjectMocks
    private RentCarService rentCarService;

    @Mock
    private RentCarRepository rentCarRepository;

    private RentCar rentCarMock = RentCarHelper.montRentCar();


//    @DisplayName("Retorna uma lista de automoveis")
//    @Test
//    void whenFindAllThenReturnListAutomoveis() {
//        when(rentCarRepository.findAll()).thenReturn(List.of(rentCarMock));
//        List<RentCar> automoveis = rentCarService.findAll();
//        List<RentCar> automoveisTest = Arrays.asList(rentCarMock);
//        verify(rentCarRepository, times(1)).findAll();
//        assertEquals(automoveis.size(), automoveisTest.size());
//        assertEquals(automoveis.hashCode(), automoveisTest.hashCode());
//    }
//
//
//
//    @DisplayName("Retorna uma lista vazia")
//    @Test
//    void whenFindAllThenReturnListEmpty() {
//        when(rentCarRepository.findAll()).thenReturn(Arrays.asList());
//        List<RentCar> automoveis = rentCarService.findAll();
//        verify(rentCarRepository, times(1)).findAll();
//        assertEquals(automoveis.size(), 0);
//    }
//
//
//
//    @DisplayName("Retorna um automovel")
//    @Test
//    void whenFindByIdThenReturnAutomovel() {
//        when(rentCarRepository.findById(anyLong())).thenReturn(Optional.of(rentCarMock));
//        RentCar car = rentCarService.findById(1L);
//        verify(rentCarRepository, times(1)).findById(anyLong());
//        assertEquals(car.getModelo(), rentCarMock.getModelo());
//        assertEquals(car.getName(), rentCarMock.getName());
//        assertEquals(car.getYear(), rentCarMock.getYear());
//        assertEquals(car.getType(), rentCarMock.getType());
//        assertEquals(car.getSeatsQuantity(), rentCarMock.getSeatsQuantity());
//        assertEquals(car.getPortQuantity(), rentCarMock.getPortQuantity());
//        assertEquals(car.getColor(), rentCarMock.getColor());
//        assertEquals(car.getShift(), rentCarMock.getShift());
//        assertEquals(car.hashCode(), rentCarMock.hashCode());
//    }
//
//
//    @DisplayName("Joga erro caso não tenha um automovel")
//    @Test
//    void whenFindByIdThenThrowNotFound() {
//        when(rentCarRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
//        assertThrows(AutomovelNotFoundException.class, () -> rentCarService.findById(1L));
//    }
//
//    @DisplayName("Deleta automovel")
//    @Test
//    void whenDeleteThenDeleteAutomovel() {
//        when(rentCarRepository.findById(anyLong())).thenReturn(Optional.of(rentCarMock));
//        rentCarService.delete(1L);
//        verify(rentCarRepository, times(1)).findById(anyLong());
//        verify(rentCarRepository, times(1)).delete(any(RentCar.class));
//    }
//
//    @DisplayName("Seta verdadeiro no isdeleted para fazer delete logico")
//    @Test
//    void whenLogicalDeleteThenSetTrueOnIsDelete() {
//        when(rentCarRepository.findById(anyLong())).thenReturn(Optional.of(rentCarMock));
//        when(rentCarRepository.save(any(RentCar.class))).thenReturn(rentCarMock);
//        rentCarService.logicalDelete(1L);
//        verify(rentCarRepository, times(1)).findById(anyLong());
//        verify(rentCarRepository, times(1)).save(any(RentCar.class));
//    }
//
//    @DisplayName("Salva um carro no estoque")
//    @Test
//    void whenSaveThenSaveAutomovelOnDb() {
//        when(rentCarRepository.save(any(RentCar.class))).thenReturn(rentCarMock);
//        rentCarService.save(rentCarMock);
//        verify(rentCarRepository, times(1)).save(any(RentCar.class));
//    }
//
//    @DisplayName("Atualiza um carro do estoque")
//    @Test
//    void whenUpdateThenUpdateAutomovelOnDb() {
//        when(rentCarRepository.findById(anyLong())).thenReturn(Optional.of(rentCarMock));
//        when(rentCarRepository.save(any(RentCar.class))).thenReturn(rentCarMock);
//        RentCar car = rentCarService.update(rentCarMock, 1L);
//        verify(rentCarRepository, times(1)).findById(anyLong());
//        verify(rentCarRepository, times(1)).save(any(RentCar.class));
//        assertEquals(car.getModelo(), rentCarMock.getModelo());
//        assertEquals(car.getName(), rentCarMock.getName());
//        assertEquals(car.getYear(), rentCarMock.getYear());
//        assertEquals(car.getType(), rentCarMock.getType());
//        assertEquals(car.getSeatsQuantity(), rentCarMock.getSeatsQuantity());
//        assertEquals(car.getPortQuantity(), rentCarMock.getPortQuantity());
//        assertEquals(car.getColor(), rentCarMock.getColor());
//        assertEquals(car.getShift(), rentCarMock.getShift());
//        assertEquals(car.hashCode(), rentCarMock.hashCode());
//    }
}
