import { TestBed } from '@angular/core/testing';

import { RestoranDtoService } from './restoran-dto.service';

describe('RestoranDtoService', () => {
  let service: RestoranDtoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestoranDtoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
