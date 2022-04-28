import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IlustrationComponent } from './ilustration.component';

describe('IlustrationComponent', () => {
  let component: IlustrationComponent;
  let fixture: ComponentFixture<IlustrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IlustrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IlustrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
