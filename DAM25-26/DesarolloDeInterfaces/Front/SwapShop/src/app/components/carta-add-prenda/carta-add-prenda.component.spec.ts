import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CartaAddPrendaComponent } from './carta-add-prenda.component';

describe('CartaAddPrendaComponent', () => {
  let component: CartaAddPrendaComponent;
  let fixture: ComponentFixture<CartaAddPrendaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [CartaAddPrendaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CartaAddPrendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
