import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { TelaIndexComponent } from './components/tela-index/tela-index.component';
import { TelaLoginComponent } from './components/tela-login/tela-login/tela-login.component';
import { TelaTriagemComponent } from './components/tela-triagem/tela-triagem/tela-triagem.component';
import { TelaFichaComponent } from './components/tela-ficha/tela-ficha/tela-ficha.component';
import { TelaDadosComponent } from './components/tela-dados/tela-dados/tela-dados.component';

@NgModule({
  declarations: [
    AppComponent,

    TelaIndexComponent,
     TelaLoginComponent,
     TelaTriagemComponent,
     TelaFichaComponent,
     TelaDadosComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
