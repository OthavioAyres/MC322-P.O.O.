## LAB03
Para estrutura inicial deste projeto utilizei o laboratorio pratico 09 (DEMOJAVAFX)

## Funcionalidades Principais

### Dashboard
- Tela inicial após o login do usuário
- Exibe informações do cliente (nome e saldo)
- Acesso às principais funcionalidades:
  - Ver ingressos
  - Marketplace
  - Comprar ingressos
  - Logout

### Marketplace
- Lista de ingressos disponíveis para compra de outros usuários
- Funcionalidades:
  - Visualizar ofertas disponíveis
  - Comprar ingressos de outros usuários
  - Ver detalhes dos eventos
  - Sistema de comissão (10% por padrão)

### Meus Ingressos
- Lista de ingressos do usuário
- Funcionalidades:
  - Visualizar ingressos adquiridos
  - Vender ingressos no marketplace
  - Ver detalhes dos eventos

### Eventos Disponíveis
- Lista de eventos disponíveis para compra direta
- Funcionalidades:
  - Visualizar eventos disponíveis
  - Comprar ingressos diretamente da organizadora
  - Ver detalhes dos eventos

## Classes Principais

### Modelo
- `Marketplace`: Gerencia as ofertas de ingressos
  - Mantém lista de ofertas disponíveis
  - Processa compras e vendas
  - Gerencia comissões

- `Cliente`: Representa um usuário do sistema
  - Gerencia saldo e ingressos
  - Realiza compras e vendas
  - Recebe notificações por email

- `OfertaIngresso`: Representa uma oferta no marketplace
  - Contém informações do ingresso
  - Preço solicitado
  - Vendedor

- `Evento`: Classe base para eventos
  - Gerencia informações do evento
  - Controla venda de ingressos
  - Mantém contagem de ingressos vendidos

### Controladores
- `DashboardController`: Gerencia a tela principal
- `MarketplaceController`: Controla a interface do marketplace
- `ListaIngressosController`: Gerencia a lista de ingressos do usuário
- `EventosDisponiveisController`: Controla a lista de eventos disponíveis
- `EventoDetalhesController`: Exibe detalhes dos eventos

### Serviços
- `MarketplaceService`: Singleton que gerencia o marketplace globalmente
- `ClienteService`: Gerencia o cliente atual da sessão
- `EventoService`: Gerencia os eventos disponíveis

## Vizualização

1. **Login/Seleção de Cliente**
   - Usuário seleciona ou faz login com sua conta

2. **Dashboard**
   - Usuário acessa as funcionalidades principais

3. **Comprando Ingressos**
   - Diretamente da organizadora:
     - Acessa "Comprar Ingressos"
     - Seleciona evento
     - Confirma compra

   - No marketplace:
     - Acessa "Marketplace"
     - Seleciona oferta
     - Confirma compra

4. **Vendendo Ingressos**
   - Acessa "Meus Ingressos"
   - Seleciona ingresso
   - Define preço
   - Confirma venda

## Notificações
- O sistema envia notificações por email para:
  - Confirmação de compra
  - Confirmação de venda
  - Débitos realizados
  - Ofertas colocadas no marketplace

## Comissões
- O marketplace cobra uma comissão padrão de 10% sobre as vendas
- O valor da comissão é deduzido do valor recebido pelo vendedor
- O pagamento é processado em até 48h após a venda 

## Uso de IA Generativa

Utilizei de IA generativa neste codigo para auxiliar na construção de algumas funções (Foi utilizado  auto complete do copilot em algumas funções com logicas simples - como por exemplo no metodo  *adicionarIngresso*, onde recebo um ingresso e adiciono a uma lista) e documentação das classes (adiciondo comentarios e descrições dos metodos para facilitação da compreensão dos avaliadores). No geral, a IA ajudou a acelerar o processo de desenvolvimento, muito em processos lentos e repetitivos. 
Utilizei principalmente o chatgpt como uma ferramenta para substituir os buscadores, onde estudava alguns temas e buscava refêrencia ou bibliografias que me permitissem entender um tema melhor.
E por fim  solicitei ajuda da IA para redigir a descrição dos titulos anteriores em este arquivo README.MD para que facilitasse o entendimento da organização do repositorio por parte dos avaliadores.

## Decisões mencionadas 
3.1.3
onde fica a logica do calculo da comissão ? e transferência de ingresso ?  e a atualização do saldo ?
Escolhi deixar o saldo como um atributo do cliente pois isso facilita a logica geral, uma vez que faz sentido pensar que cada cliente possui um saldo individual que sempre será associado a ele (como o email do cliente por exemplo que pode até mudar mas nao faz sentido sem o cliente). Dito isto, também para simplificar o entendimento de todo o serviço: o calculo da comissão, juntamente com a atualização do saldo e transfêrencia do ingresso ocorrem por meio da classe marketplace, que é responsavel por chamar estas alterações uma vêz que um ingresso seja vendido, além de ser a mesma classe quem "recebera" a comissão.

O saldo dos clientes é atualizado na compra de um ingresso. (Mostro uma noticação de que o saldo devera ser atualizado em até 48h).

Referências utilizadas :
Estruturas MVC em java.
https://www.devmedia.com.br/padrao-mvc-java-magazine/21995
https://medium.com/@robson.trasel/desvendando-o-padr%C3%A3o-mvc-em-java-um-guia-did%C3%A1tico-com-exemplos-ca1ba487f5fb
 