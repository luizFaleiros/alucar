package br.com.alucar.services;

import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.CambioEnum;
import br.com.alucar.domain.enums.ColorEnum;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.repositories.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

@DisplayName("Teste da classe Aluguel")
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    private Car carMock = Car.builder()
            .modelo("XYZ")
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
            .type(AutoTypeEnum.MIDDLE)
                .seatsQuantity(Integer.toUnsignedLong(5))
            .portQuantity(Integer.toUnsignedLong(2))
            .color(ColorEnum.WHITE)
                .shift(CambioEnum.MANUAL)
                .isDeleted(false)
                .build();

    @DisplayName("Retorna uma lista de automoveis")
    @Test
    void whenFindAllThenReturnListAutomoveis() {
        when(carRepository.findAll()).thenReturn(List.of(carMock));
        List<Car> automoveis = carService.findAll();
        List<Car> automoveisTest = Arrays.asList(carMock);
        verify(carRepository, times(1)).findAll();
        assertEquals(automoveis.size(),automoveisTest.size());
        assertEquals(automoveis.hashCode(), automoveisTest.hashCode());
    }


    @DisplayName("Retorna uma lista vazia")
    @Test
    void whenFindAllThenReturnListEmpty() {
        when(carRepository.findAll()).thenReturn(Arrays.asList());
        List<Car> automoveis = carService.findAll();
        verify(carRepository, times(1)).findAll();
        assertEquals(automoveis.size(),0);
    }

    @DisplayName("Retorna um automovel")
    @Test
    void whenFindByIdThenReturnAutomovel() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(carMock));
        Car car = carService.findById(1L);
        verify(carRepository, times(1)).findById(anyLong());
        assertEquals(car.getModelo(), carMock.getModelo());
        assertEquals(car.getName(), carMock.getName());
        assertEquals(car.getYear(), carMock.getYear());
        assertEquals(car.getType(), carMock.getType());
        assertEquals(car.getSeatsQuantity(), carMock.getSeatsQuantity());
        assertEquals(car.getPortQuantity(), carMock.getPortQuantity());
        assertEquals(car.getColor(), carMock.getColor());
        assertEquals(car.getShift(), carMock.getShift());
        assertEquals(car.hashCode(), carMock.hashCode());
    }


    @DisplayName("Joga erro caso não tenha um automovel")
    @Test
    void whenFindByIdThenThrowNotFound() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(AutomovelNotFoundException.class, () -> carService.findById(1L));
    }

    @DisplayName("Deleta automovel")
    @Test
    void whenDeleteThenDeleteAutomovel() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(carMock));
        carService.delete(1L);
        verify(carRepository, times(1)).findById(anyLong());
        verify(carRepository, times(1)).delete(any(Car.class));
    }

    @DisplayName("Seta verdadeiro no isdeleted para fazer delete logico")
    @Test
    void whenLogicalDeleteThenSetTrueOnIsDelete() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(carMock));
        when(carRepository.save(any(Car.class))).thenReturn(carMock);
        carService.logicalDelete(1L);
        verify(carRepository, times(1)).findById(anyLong());
        verify(carRepository, times(1)).save(any(Car.class));
    }

    @DisplayName("Salva um carro no estoque")
    @Test
    void whenSaveThenSaveAutomovelOnDb() {
        when(carRepository.save(any(Car.class))).thenReturn(carMock);
        carService.save(carMock);
        verify(carRepository, times(1)).save(any(Car.class));
    }

    @DisplayName("Atualiza um carro do estoque")
    @Test
    void whenUpdateThenUpdateAutomovelOnDb() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(carMock));
        when(carRepository.save(any(Car.class))).thenReturn(carMock);
        Car car = carService.update(carMock, 1L);
        verify(carRepository, times(1)).findById(anyLong());
        verify(carRepository, times(1)).save(any(Car.class));
        assertEquals(car.getModelo(), carMock.getModelo());
        assertEquals(car.getName(), carMock.getName());
        assertEquals(car.getYear(), carMock.getYear());
        assertEquals(car.getType(), carMock.getType());
        assertEquals(car.getSeatsQuantity(), carMock.getSeatsQuantity());
        assertEquals(car.getPortQuantity(), carMock.getPortQuantity());
        assertEquals(car.getColor(), carMock.getColor());
        assertEquals(car.getShift(), carMock.getShift());
        assertEquals(car.hashCode(), carMock.hashCode());
    }

}
