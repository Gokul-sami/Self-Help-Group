package com.self_help_group.self_help_group;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.self_help_group.self_help_group.domain.Ledger;
import com.self_help_group.self_help_group.domain.Resolution;
import com.self_help_group.self_help_group.domain.Savings;
import com.self_help_group.self_help_group.service.LedgerService;
import com.self_help_group.self_help_group.service.ResolutionService;
import com.self_help_group.self_help_group.service.SavingsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LedgerService ledgerService;

    @MockBean
    private ResolutionService resolutionService;

    @MockBean
    private SavingsService savingsService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetLedger() throws Exception {
        when(ledgerService.getLedger()).thenReturn(List.of());

        mockMvc.perform(get("/ledger"))
                .andExpect(status().isOk())
                .andExpect(view().name("ledger"));
                // .andExpect(model().attributeExists("ledger"));
    }

    @Test
    public void testAddLedger() throws Exception {
        Ledger ledger = new Ledger();
        ledger.setDescription("Test Entry");

        when(ledgerService.addLedger("20-05-2025", "Test Entry", 3000, 0, 3000)).thenReturn(ledger);

        mockMvc.perform(post("/ledger")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ledger)))
                .andExpect(status().isOk())
                .andExpect(view().name("Ledger"));
                // .andExpect(model().attributeExists("ledger"));
    }

    @Test
    public void testGetResolution() throws Exception {
        when(resolutionService.getAllResolutions()).thenReturn(List.of());

        mockMvc.perform(get("/resolution"))
                .andExpect(status().isOk())
                .andExpect(view().name("resolution"));
                // .andExpect(model().attributeExists("resolutions"));
    }

    @Test
    public void testAddResolution() throws Exception {
        Resolution resolution = new Resolution();
        resolution.setRes_name("Meeting");

        when(resolutionService.addResolution(null, "Meeting", null, null, null, null, null)).thenReturn(resolution);

        mockMvc.perform(post("/resolution")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(resolution)))
                .andExpect(status().isOk())
                .andExpect(view().name("resolution"));
                // .andExpect(model().attributeExists("resolution"));
    }

    @Test
    public void testGetMonthlySavings() throws Exception {
        Savings savings = new Savings();
        savings.setYear(2024);
        savings.setMonth("April");
        savings.setAmount(5000);

        List<Savings> savingsList = Arrays.asList(savings);
        when(savingsService.getSavings()).thenReturn(savingsList);

        mockMvc.perform(get("/monthly-savings"))
                .andExpect(status().isOk())
                .andExpect(view().name("monthly-savings"));
                // .andExpect(model().attributeExists("savings"));
    }

    @Test
    public void testAddMonthlySavings() throws Exception {
        Savings savings = new Savings();
        savings.setYear(2024);
        savings.setMonth("April");
        savings.setAmount(5000);

        when(savingsService.addSavings(2024, "April", 5000)).thenReturn(savings);

        mockMvc.perform(post("/monthly-savings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(savings)))
                .andExpect(status().isOk())
                .andExpect(view().name("monthly-savings"));
                // .andExpect(model().attributeExists("savings"));
    }

    @Test
    public void testGetMonthlyDetails() throws Exception {
        mockMvc.perform(get("/monthly-details"))
                .andExpect(status().isOk())
                .andExpect(view().name("monthly-details"));
    }

    @Test
    public void testGetLogoutPage() throws Exception {
        mockMvc.perform(get("/logout"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testGetNotifications() throws Exception {
        mockMvc.perform(get("/notifications"))
                .andExpect(status().isOk())
                .andExpect(view().name("notifications"));
    }
}
