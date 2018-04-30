import { TestBed, inject } from '@angular/core/testing';

import { SalaryCalculationClientService } from './salary-calculation-client.service';

describe('SalaryCalculationClientService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalaryCalculationClientService]
    });
  });

  it('should be created', inject([SalaryCalculationClientService], (service: SalaryCalculationClientService) => {
    expect(service).toBeTruthy();
  }));
});
