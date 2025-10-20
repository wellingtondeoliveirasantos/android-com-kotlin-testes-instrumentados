# 📱 Orgs App - Projeto Android com Kotlin

Aplicativo Android desenvolvido em **Kotlin**, utilizando boas práticas de arquitetura moderna e bibliotecas oficiais do Android Jetpack.  
O projeto tem como objetivo gerenciar produtos, permitindo cadastrar, editar, listar e visualizar informações de forma simples e intuitiva.

---

## 🎓 Sobre este projeto

Este projeto é **um estudo pessoal desenvolvido pela Alura**, criado para praticar os conceitos aprendidos no curso **“Testes Instrumentados em Android”** da **Alura**.  
Todo o código e estrutura seguem os exercícios e boas práticas do curso, com adaptações e melhorias próprias.

---

## 🚀 Tecnologias e Ferramentas

- **Linguagem:** Kotlin
- **Arquitetura:** MVVM
- **Banco de Dados:** Room
- **Persistência:** DataStore
- **Concorrência:** Kotlin Coroutines
- **Injeção de Dependência:** (caso adicione futuramente, ex: Hilt ou Koin)
- **UI:** Material Design + ConstraintLayout + RecyclerView
- **Carregamento de Imagens:** Coil
- **Testes:**
    - Unitários com **JUnit** e **MockK**
    - Instrumentados com **Espresso** e **AndroidJUnitRunner**

---

## 🧩 Estrutura do Projeto

```bash
📂 br.com.alura.orgs
├── 🧠 viewmodel      → Lógica de apresentação
├── 🧱 model          → Entidades e data classes
├── 🗃️ dao            → DAOs do Room
├── 💾 database       → Configuração do banco local
├── 🎨 ui             → Activities / Fragments / Adapters
└── ⚙️ util           → Classes auxiliares
```

---

## 🧰 Configuração do Ambiente

### 🔹 Pré-requisitos

* **Android Studio** Giraffe (ou superior)
* **JDK 21**
* **Gradle 8.6+**
* **Emulador ou dispositivo com Android 8.0 (API 24)** ou superior

### 🔹 Clonar o projeto

```bash
git clone git@github.com:wellingtondeoliveirasantos/android-com-kotlin-testes-instrumentados.git
cd android-kotlin-testes
```

### 🔹 Abrir no Android Studio

1. Vá em **File > Open...**
2. Selecione a pasta do projeto
3. Aguarde o Gradle sincronizar automaticamente

---

## 🧪 Testes

### Executar testes unitários

```bash
./gradlew test
```

### Executar testes instrumentados

```bash
./gradlew connectedAndroidTest
```

---

## 🧱 Principais Dependências

| Biblioteca | Versão  | Descrição                      |
| ---------- | ------- | ------------------------------ |
| Room       | 2.6.1   | Persistência local com ORM     |
| Lifecycle  | 2.8.6   | Gerenciamento de ciclo de vida |
| DataStore  | 1.1.1   | Armazenamento de preferências  |
| Coroutines | 1.9.0   | Execução assíncrona            |
| Coil       | 2.6.0   | Carregamento de imagens        |
| Espresso   | 3.6.1   | Testes de interface            |
| MockK      | 1.13.12 | Mocking em Kotlin              |

---

## 🧾 Licença

Este projeto é distribuído sob a licença **MIT**.
Sinta-se à vontade para usar, modificar e contribuir!

---

### 💬 Autor

👤 **Wellington Santos**  
📧 [LinkedIn](https://www.linkedin.com/in/wellington-staff-qa-expert/)  
📍 QA Automation apaixonado por qualidade e aprendizado contínuo.