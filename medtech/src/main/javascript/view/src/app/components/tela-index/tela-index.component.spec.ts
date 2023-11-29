import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaIndexComponent } from './tela-index.component';

describe('TelaIndexComponent', () => {
  let component: TelaIndexComponent;
  let fixture: ComponentFixture<TelaIndexComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelaIndexComponent]
    });
    fixture = TestBed.createComponent(TelaIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
