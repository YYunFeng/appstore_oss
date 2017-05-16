package interceptor;

import com.jd.digital.common.util.tool.MD5Util;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * **************************************************
 *
 * @author sunbingwei@360buy.com
 *         date: Feb 23, 2011
 *         <p/>
 *         ***************************************************
 */
public class CheckSOAPHeaderIntercepter extends AbstractPhaseInterceptor<SoapMessage> {
    private SAAJInInterceptor saaIn = new SAAJInInterceptor();
    private static final Log log = LogFactory.getLog(CheckSOAPHeaderIntercepter.class);
    private String namespaceURI = "http://man.360buy.net/services/";
    private String localPart = "AuthenticationHeader";
    private AuthHeader authHeader;

    public CheckSOAPHeaderIntercepter() {
        super(Phase.PRE_PROTOCOL);
        getAfter().add(SAAJInInterceptor.class.getName());
    }


    public void handleMessage(SoapMessage message) throws Fault {
        if (!checkQnameHeader(message) && !checkMessageHeader(message)) {
            log.error("Token wrong! ");
            throw new IllegalArgumentException("Token wrong! ");
        }
    }

    private boolean checkQnameHeader(SoapMessage message) {
        org.apache.cxf.binding.soap.SoapHeader soapHeader = (org.apache.cxf.binding.soap.SoapHeader) message.getHeader(new QName(namespaceURI, localPart));
        if (soapHeader == null) return false;

        ElementNSImpl ei = (ElementNSImpl) soapHeader.getObject();

        String token;
        try {
            token = ei.getFirstChild().getFirstChild().getTextContent();
            return authHeader.checkTokenValue(token);
        } catch (Exception e) {
            throw new IllegalArgumentException("Method --> checkQnameHeader error", e);
        }
    }

    /**
     * SOAPHeader 验证方式
     *
     * @param message SoapMessage
     * @return boolean
     */
    private boolean checkMessageHeader(SoapMessage message) {
        try {
            SOAPMessage mess = message.getContent(SOAPMessage.class);
            if (mess == null) {
                saaIn.handleMessage(message);
                mess = message.getContent(SOAPMessage.class);
            }
            SOAPHeader head = mess.getSOAPHeader();
            if (head == null) return false;

            NodeList nodes = head.getElementsByTagName(localPart);
            if (nodes == null) return false;

            String token = "";
            for (int i = 0; i < nodes.getLength(); i++) {
                token += nodes.item(i).getTextContent();
            }

            return authHeader.checkTokenValue(token);
        } catch (Exception e) {
            throw new IllegalArgumentException("Method --> checkMessageHeader error!", e);
        }
    }

    public String getNamespaceURI() {
        return namespaceURI;
    }

    public void setNamespaceURI(String namespaceURI) {
        this.namespaceURI = namespaceURI;
    }

    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    public void setAuthHeader(AuthHeader authHeader) {
        this.authHeader = authHeader;
    }

    public static void main(String args[]) {
        System.out.println(new String(Base64.encodeBase64(MD5Util.md5("promotion201003151317" + "-" + "promotion201003151317"))));
    }

}
