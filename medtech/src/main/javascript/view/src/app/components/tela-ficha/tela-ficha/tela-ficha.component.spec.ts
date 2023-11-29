import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaFichaComponent } from './tela-ficha.component';

describe('TelaFichaComponent', () => {
  let component: TelaFichaComponent;
  let fixture: ComponentFixture<TelaFichaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelaFichaComponent]
    });
    fixture = TestBed.createComponent(TelaFichaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
