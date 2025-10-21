package br.com.alura.orgs

import android.app.Activity
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Before
import org.junit.Test

class ProdutosTelasTests {

    @Before
    fun preparaAmbiente() {
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

    // ---------- TESTES DE VISIBILIDADE ----------

    @Test
    fun deveMostrarONomeDoAplicativoNaLista() {
        launchActivityComTitulo(ListaProdutosActivity::class.java, "Orgs")
    }

    @Test
    fun deveMostrarNomeDoAplicativoNaTelaDeLogin() {
        launchActivityComTitulo(LoginActivity::class.java, "Orgs")
    }

    @Test
    fun deveMostrarCamposParaCriarProduto() {
        launch(FormularioProdutoActivity::class.java)
        verificarCamposVisiveis(
            R.id.activity_formulario_produto_nome,
            R.id.activity_formulario_produto_descricao,
            R.id.activity_formulario_produto_valor,
            R.id.activity_formulario_produto_botao_salvar
        )
    }

    @Test
    fun deveMostrarCamposParaFazerLogin() {
        launch(LoginActivity::class.java)
        verificarCamposVisiveis(
            R.id.activity_login_usuario,
            R.id.activity_login_senha,
            R.id.activity_login_botao_entrar
        )
    }

    @Test
    fun deveMostrarCamposParaCadastro() {
        launch(FormularioCadastroUsuarioActivity::class.java)
        verificarCamposVisiveis(
            R.id.activity_formulario_cadastro_usuario,
            R.id.activity_formulario_cadastro_email,
            R.id.activity_formulario_cadastro_senha,
            R.id.activity_formulario_cadastro_botao_cadastrar
        )
    }

    // ---------- TESTES DE AÇÃO ----------

    @Test
    fun devePreencherCamposESalvarProduto() {
        launch(ListaProdutosActivity::class.java)
        adicionarProduto("Banana", "Banana ouro", "6.99")
        onView(withText("Banana")).check(matches(isDisplayed()))
    }

    @Test
    fun deveEditarProduto() {
        launch(ListaProdutosActivity::class.java)

        // Cria produto inicial
        adicionarProduto("Banana verde", "Da feira", "2.99")

        // Edita produto
        clicarFAB()
        editarProduto(
            nome = "Banana nanica",
            descricao = "Da feira",
            valor = "5.99"
        )

        // Edita novamente nos detalhes
        onView(withText("Banana nanica")).perform(click())
        onView(withId(R.id.menu_detalhes_produto_editar)).perform(click())
        editarProduto(
            nome = "Banana Ouro",
            descricao = "Da venda",
            valor = "3.99",
            replaceText = true
        )
    }

    // ---------- FUNÇÕES UTILITÁRIAS ----------

    private fun launchActivityComTitulo(activityClass: Class<out Activity>, titulo: String) {
        launch(activityClass)
        onView(withText(titulo)).check(matches(isDisplayed()))
    }

    private fun verificarCamposVisiveis(vararg ids: Int) {
        ids.forEach { id ->
            onView(withId(id)).check(matches(isDisplayed()))
        }
    }

    private fun clicarFAB() {
        onView(withId(R.id.activity_lista_produtos_fab)).perform(click())
    }

    private fun adicionarProduto(nome: String, descricao: String, valor: String) {
        clicarFAB()
        preencherCamposProduto(nome, descricao, valor)
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(click())
    }

    private fun editarProduto(nome: String, descricao: String, valor: String, replaceText: Boolean = false) {
        val action = if (replaceText) ::replaceText else ::typeText

        onView(withId(R.id.activity_formulario_produto_nome)).perform(action(nome))
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(action(descricao))
        onView(withId(R.id.activity_formulario_produto_valor)).perform(action(valor))

        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(click())
    }

    private fun preencherCamposProduto(nome: String, descricao: String, valor: String) {
        onView(withId(R.id.activity_formulario_produto_nome)).perform(typeText(nome))
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(typeText(descricao))
        onView(withId(R.id.activity_formulario_produto_valor)).perform(typeText(valor))
    }
}
