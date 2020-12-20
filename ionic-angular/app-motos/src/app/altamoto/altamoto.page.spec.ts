import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { AltamotoPage } from './altamoto.page';

describe('AltamotoPage', () => {
  let component: AltamotoPage;
  let fixture: ComponentFixture<AltamotoPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AltamotoPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(AltamotoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
