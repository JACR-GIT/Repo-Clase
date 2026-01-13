import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CategoriasCheckboxComponent } from './categorias-checkbox.component';

describe('CategoriasCheckboxComponent', () => {
  let component: CategoriasCheckboxComponent;
  let fixture: ComponentFixture<CategoriasCheckboxComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoriasCheckboxComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CategoriasCheckboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
