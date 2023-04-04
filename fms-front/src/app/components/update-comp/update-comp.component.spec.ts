import { ComponentFixture, TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { UpdateCompComponent } from './update-comp.component';

describe('UpdateCompComponent', () => {
  let component: UpdateCompComponent;
  let fixture: ComponentFixture<UpdateCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [UpdateCompComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UpdateCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
