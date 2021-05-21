package br.com.alucar.services;

import br.com.alucar.domain.entities.Automovel;
import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.CambioEnum;
import br.com.alucar.domain.enums.ColorEnum;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.repositories.AutomoveisRepository;
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
public class AutoMoveisServiceTest {

    @InjectMocks
    private AutoMoveisService autoMoveisService;

    @Mock
    private AutomoveisRepository automoveisRepository;

    private Automovel automovelMock = Automovel.builder()
            .modelo("XYZ")
                .nome("Gol")
                .ano(Integer.toUnsignedLong(1983))
            .type(AutoTypeEnum.MIDDLE)
                .seatsQuantity(Integer.toUnsignedLong(5))
            .portQuantity(Integer.toUnsignedLong(2))
            .color(ColorEnum.WHITE)
                .cambio(CambioEnum.MANUAL)
                .isDeleted(false)
                .build();

    @DisplayName("Retorna uma lista de automoveis")
    @Test
    void whenFindAllThenReturnListAutomoveis() {
        when(automoveisRepository.findAll()).thenReturn(List.of(automovelMock));
        List<Automovel> automoveis = autoMoveisService.findAll();
        List<Automovel> automoveisTest = Arrays.asList(automovelMock);
        verify(automoveisRepository, times(1)).findAll();
        assertEquals(automoveis.size(),automoveisTest.size());
        assertEquals(automoveis.hashCode(), automoveisTest.hashCode());
    }


    @DisplayName("Retorna uma lista vazia")
    @Test
    void whenFindAllThenReturnListEmpty() {
        when(automoveisRepository.findAll()).thenReturn(Arrays.asList());
        List<Automovel> automoveis = autoMoveisService.findAll();
        verify(automoveisRepository, times(1)).findAll();
        assertEquals(automoveis.size(),0);
    }

    @DisplayName("Retorna um automovel")
    @Test
    void whenFindByIdThenReturnAutomovel() {
        when(automoveisRepository.findById(anyLong())).thenReturn(Optional.of(automovelMock));
        Automovel automovel = autoMoveisService.findById(1L);
        verify(automoveisRepository, times(1)).findById(anyLong());
        assertEquals(automovel.getModelo(),automovelMock.getModelo());
        assertEquals(automovel.getNome(),automovelMock.getNome());
        assertEquals(automovel.getAno(),automovelMock.getAno());
        assertEquals(automovel.getType(),automovelMock.getType());
        assertEquals(automovel.getSeatsQuantity(),automovelMock.getSeatsQuantity());
        assertEquals(automovel.getPortQuantity(),automovelMock.getPortQuantity());
        assertEquals(automovel.getColor(),automovelMock.getColor());
        assertEquals(automovel.getCambio(),automovelMock.getCambio());
        assertEquals(automovel.hashCode(), automovelMock.hashCode());
    }


    @DisplayName("Joga erro caso não tenha um automovel")
    @Test
    void whenFindByIdThenThrowNotFound() {
        when(automoveisRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(AutomovelNotFoundException.class, () -> autoMoveisService.findById(1L));
    }

    @DisplayName("Deleta automovel")
    @Test
    void whenDeleteThenDeleteAutomovel() {
        when(automoveisRepository.findById(anyLong())).thenReturn(Optional.of(automovelMock));
        autoMoveisService.delete(1L);
        verify(automoveisRepository, times(1)).findById(anyLong());
        verify(automoveisRepository, times(1)).delete(any(Automovel.class));
    }

    @DisplayName("Seta verdadeiro no isdeleted para fazer delete logico")
    @Test
    void whenLogicalDeleteThenSetTrueOnIsDelete() {
        when(automoveisRepository.findById(anyLong())).thenReturn(Optional.of(automovelMock));
        when(automoveisRepository.save(any(Automovel.class))).thenReturn(automovelMock);
        autoMoveisService.logicalDelete(1L);
        verify(automoveisRepository, times(1)).findById(anyLong());
        verify(automoveisRepository, times(1)).save(any(Automovel.class));
    }

    @DisplayName("Salva um carro no estoque")
    @Test
    void whenSaveThenSaveAutomovelOnDb() {
        when(automoveisRepository.save(any(Automovel.class))).thenReturn(automovelMock);
        autoMoveisService.save(automovelMock);
        verify(automoveisRepository, times(1)).save(any(Automovel.class));
    }

    @DisplayName("Atualiza um carro do estoque")
    @Test
    void whenUpdateThenUpdateAutomovelOnDb() {
        when(automoveisRepository.findById(anyLong())).thenReturn(Optional.of(automovelMock));
        when(automoveisRepository.save(any(Automovel.class))).thenReturn(automovelMock);
        Automovel automovel = autoMoveisService.update(automovelMock, 1L);
        verify(automoveisRepository, times(1)).findById(anyLong());
        verify(automoveisRepository, times(1)).save(any(Automovel.class));
        assertEquals(automovel.getModelo(),automovelMock.getModelo());
        assertEquals(automovel.getNome(),automovelMock.getNome());
        assertEquals(automovel.getAno(),automovelMock.getAno());
        assertEquals(automovel.getType(),automovelMock.getType());
        assertEquals(automovel.getSeatsQuantity(),automovelMock.getSeatsQuantity());
        assertEquals(automovel.getPortQuantity(),automovelMock.getPortQuantity());
        assertEquals(automovel.getColor(),automovelMock.getColor());
        assertEquals(automovel.getCambio(),automovelMock.getCambio());
        assertEquals(automovel.hashCode(), automovelMock.hashCode());
    }

}
