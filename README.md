# TurnedOffModem

Aplicativo Android simples que faz login na interface web do modem e executa ações como reinicialização.

## 📱 Funcionalidade

- Acessa a página do modem (`http://192.168.0.1`) via `WebView`.
- Preenche automaticamente o login e senha.
- Executa o botão de login via JavaScript.
- (Em breve) executa comandos como reiniciar o modem.

> ⚠️ Este app **só funciona em dispositivos reais** conectados à mesma rede do modem. O emulador **não consegue acessar o IP do modem**.

## 🔧 Requisitos

- Android Studio (API 21+)
- Dispositivo Android conectado via Wi-Fi
- Permissão de acesso à internet no `AndroidManifest.xml`

## 📂 Estrutura

- `MainActivity.java`: carrega o WebView e executa o login.
- `activity_main.xml`: layout com botão e WebView.
- `AndroidManifest.xml`: contém permissão de internet.

## ✅ Como usar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/TurnedOffModem.git
