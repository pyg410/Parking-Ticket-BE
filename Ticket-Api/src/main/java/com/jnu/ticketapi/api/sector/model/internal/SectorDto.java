package com.jnu.ticketapi.api.sector.model.internal;


import lombok.Builder;

@Builder
public record SectorDto(Long sectorId, String sectorNum, String sectorName) {}
