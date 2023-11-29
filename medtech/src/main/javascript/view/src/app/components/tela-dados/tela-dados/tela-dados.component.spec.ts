import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaDadosComponent } from './tela-dados.component';

describe('TelaDadosComponent', () => {
  let component: TelaDadosComponent;
  let fixture: ComponentFixture<TelaDadosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelaDadosComponent]
    });
    fixture = TestBed.createComponent(TelaDadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
