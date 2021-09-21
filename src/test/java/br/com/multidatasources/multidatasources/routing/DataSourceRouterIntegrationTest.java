package br.com.multidatasources.multidatasources.routing;

import br.com.multidatasources.multidatasources.MultiDataSourcesApplicationTests;
import br.com.multidatasources.multidatasources.model.Billionaire;
import br.com.multidatasources.multidatasources.model.factory.BillionaireBuilder;
import br.com.multidatasources.multidatasources.service.BillionaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DataSourceRouterIntegrationTest extends MultiDataSourcesApplicationTests {

    @Autowired
    private BillionaireService billionaireService;

    @Test
    void givenAWriteTransaction_whenSave_thenReturnPersistedObjectInTheMasterDatabaseSchema() {
        Billionaire billionaire = new BillionaireBuilder()
                                        .firstName("Jonathan")
                                        .lastName("Henrique")
                                        .career("Spring Enthusiast.")
                                        .build();

        Billionaire actual = billionaireService.save(billionaire);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isOne();
        assertThat(actual.getFirstName()).isEqualTo("Jonathan");
        assertThat(actual.getLastName()).isEqualTo("Henrique");
        assertThat(actual.getCareer()).isEqualTo("Spring Enthusiast.");
    }

    @Test
    void givenAReadTransaction_whenFindAll_thenThrownDataAccessException() {
        assertThatThrownBy(billionaireService::findAll).isInstanceOf(DataAccessException.class);
    }

}
