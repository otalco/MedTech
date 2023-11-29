import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaTriagemComponent } from './tela-triagem.component';

describe('TelaTriagemComponent', () => {
  let component: TelaTriagemComponent;
  let fixture: ComponentFixture<TelaTriagemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelaTriagemComponent]
    });
    fixture = TestBed.createComponent(TelaTriagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
