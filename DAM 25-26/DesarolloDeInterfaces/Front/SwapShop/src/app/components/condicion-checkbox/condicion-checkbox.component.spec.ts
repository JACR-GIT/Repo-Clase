import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CondicionCheckboxComponent } from './condicion-checkbox.component';

describe('CondicionCheckboxComponent', () => {
  let component: CondicionCheckboxComponent;
  let fixture: ComponentFixture<CondicionCheckboxComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CondicionCheckboxComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CondicionCheckboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
