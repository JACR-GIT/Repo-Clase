import { TestBed } from '@angular/core/testing';

import { IntercambiosprestamosService } from './intercambiosprestamos-service';

describe('IntercambiosprestamosService', () => {
  let service: IntercambiosprestamosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IntercambiosprestamosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
