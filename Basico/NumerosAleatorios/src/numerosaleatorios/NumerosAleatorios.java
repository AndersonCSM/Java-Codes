package numerosaleatorios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.plaf.basic.BasicComboBoxUI;
/**
 *
 * @author Anderson Carlos
 * 06/08/2023
 * 
 */
public class NumerosAleatorios {
    private static int wins = 0; // Quantidade de Vitórias 
    private static int trys = 0; // Quantidade de tentativas
    
    private static JLabel tryLB; // Texto da quantidade de tentativas
    private static JLabel winsLB; // Texto da quantidade de Vitórias
    private static JLabel numMac; // Texto do número da máquina
    private static JLabel numHum; // Texto do número do jogador
    private static JLabel lastRes; // Texto do último resultado
    
    private static JComboBox<String> compList; // Lista suspensa de opções de comparação
    
    
    // definindo a função gerarNumeros
    private static void gerarNumeros(){
        Random random = new Random(); // Objeto random da biblioteca random
        int numMacR = random.nextInt(101); // Número aleatório da máquina entre 0 e 100
        int numHumR = random.nextInt(101); // Número aleatório do usuário entre 0 e 100
        
        String comparacao = (String) compList.getSelectedItem(); // resgata o sinal de comparação
        boolean resultado = false; // reseta o resultado para cada chamada
        
        // escolhe o teste comparativo para cada sinal de comparação
        switch (comparacao) {
            case "=":
                resultado = (numMacR == numHumR);
                break;
            case "<":
                resultado = (numMacR < numHumR);
                break;
            case ">":
                resultado = (numMacR > numHumR);
                break;
        }
        
        trys ++; // Soma a quantidade de tentativas do usuário
        
        if (resultado) {
            wins ++; // Soma a quantidade de tentativas verdadeiras do usuário
        }
        
        // Atualização do campo texto das Labels do Frame
        lastRes.setText("Último Resultado Avaliado: " + numMacR + " " + comparacao + " " + numHumR); // Label da última tentativa avaliada
        numMac.setText(numMacR+"   "); // Label do número da máquina
        numHum.setText(numHumR+""); // Label do número do usuário
        winsLB.setText("Acertos: " + wins); // Label do número de vezes que a condição foi verdadeira
        tryLB.setText("Tentativas: " + trys); // Label da quantidade de tentativas
    }
    
    // Função main
    public static void main(String[] args) {
        JFrame frame = new JFrame("Números Aleatórios"); // Frame principal e único
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configuração do frame
        frame.setLayout(new GridLayout(0, 1)); // Grid com uma única coluna e várias linhas
        frame.pack(); // Organização dos elementos
        frame.setSize(300, 250); // Tamanho do frame
        frame.setVisible(true); // Visibilidade do frame
        
        // Título do projeto
        JLabel tituloLb = new JLabel("Números Aleatórios"); // Instancia um objeto Label
        tituloLb.setFont(new Font("Arial", Font.BOLD, 24)); // Configura a Letra do Label
        tituloLb.setHorizontalAlignment(JLabel.CENTER); // Configura o alinhamento do Label
        
        // Texto secundário
        JLabel comentLb = new JLabel("<html><center>Teste sua sorte contra a máquina!<br>Teste diferentes comparações</center></html>"); // Instancia um objeto Label
        comentLb.setFont(new Font("Arial", Font.BOLD, 12)); // Configura a Letra do Label
        comentLb.setHorizontalAlignment(JLabel.CENTER); // Configura o alinhamento do Label
        
        // Cada linha é um painel, criando os paineis(linhas do Frame)
        JPanel l1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Configura o alinhamento do Panel
        JPanel l2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Configura o alinhamento do Panel
        JPanel l3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Configura o alinhamento do Panel
        JPanel l4 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Configura o alinhamento do Panel
        
        // Instanciando as variáveis 
        numMac = new JLabel("Número da Máquina:"); // Texto normal
        numHum = new JLabel("Número do Usuário:"); // Texto normal
        compList = new JComboBox<>(new String[]{"=", "<", ">"}); // Lista susppensa com suas opções
        tryLB = new JLabel(""); // Instanciando texto
        tryLB.setHorizontalAlignment(JLabel.CENTER); // Deixando o texto centralizado
        winsLB = new JLabel(""); // Instanciando texto
        winsLB.setHorizontalAlignment(JLabel.CENTER); // Deixando o texto centralizado
        lastRes = new JLabel(""); // Texto da última tentativa
        lastRes.setHorizontalAlignment(JLabel.CENTER); // Deixando o texto centralizado
        
        // Instanciando o Botão de ação
        JButton gerarNum = new JButton("Gerar Números");
        gerarNum.setPreferredSize(new Dimension(150, 25)); // Redimensionando o tamanho do botão
        
        // Painel um, adicionando recursos do painel um, em ordem de chamada
        l1.add(numMac);
        l1.add(compList);
        l1.add(numHum);
        
        // Painel dois, adicionando recursos do painel dois, em ordem de chamada
        l2.add(gerarNum);
        
        // Painel três, adicionando recursos do painel três, em ordem de chamada
        l3.add(winsLB);
        l3.add(tryLB);
        
        // Painel quatro, adicionando recursos do painel quatro, em ordem de chamada
        l4.add(lastRes);
        
        // Adicionando as linhas ao Frame
        frame.add(tituloLb); // Adicionando os textos diretamente sem uso de Panels
        frame.add(comentLb); // Adicionando os textos diretamente sem uso de Panels
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        
        // Criando um objeto ação para o botão
        ActionListener gerarNumA = new ActionListener(){
            @Override // Sobrescrita do método, garantido que terá uma ação
            public void actionPerformed(ActionEvent e){
                gerarNumeros();
            }
        };
        
        // Adicionando a ação ao botão
        gerarNum.addActionListener(gerarNumA);
    
        // Personalizando o visual da lista suspensa, basicamente esconder a seta
        // Instanciando um objeto visual
        BasicComboBoxUI compListV = new BasicComboBoxUI(){
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0; // Esconde o botão da seta
                        }
                    };
                }
            };
        
        // Adicionando o visual a lista suspensa
        compList.setUI(compListV);
    }
}
