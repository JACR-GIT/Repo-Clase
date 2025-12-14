import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CabeceraUsuariperfilComponent } from './cabecera-usuariperfil.component';

describe('CabeceraUsuariperfilComponent', () => {
  let component: CabeceraUsuariperfilComponent;
  let fixture: ComponentFixture<CabeceraUsuariperfilComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CabeceraUsuariperfilComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CabeceraUsuariperfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
